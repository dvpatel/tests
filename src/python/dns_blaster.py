""" DNS Blaster"""
import logging.config
import logging
import sys
import time
import concurrent.futures
import random
import string
import dns.resolver

DOMAINS = ['google.com', 'yahoo.com', 'bing.com', 'netflix.com', 'mlb.com']
RANDOM_HOSTS_COUNT=150
WORKER_THREADS = 125
BLASTER_LOOP_COUNT = 10
USE_TCP = True


#  Setup loggers from external conf
logging.config.fileConfig('logging.conf')
logger = logging.getLogger('dns_blaster')

def generate_random_host(domains: list, count: int) -> list:
    """ Random FQDN Host Generator """
    
    domain_count:int = len(domains)-1
    random_hosts: list = []
    for i in range(count) :
        logger.debug('generating random host for count {}'.format(i))
        selected_domain:str = domains[random.randint(0,domain_count)]
        generated_hostname: str = str.lower(''.join(random.choices(string.ascii_letters + string.digits, k=16)))
        random_fqdn: str = generated_hostname + '.' + selected_domain

        logger.debug('Random FQDN:  {}'.format(random_fqdn))
        random_hosts.append(random_fqdn)

    return random_hosts


def get_answers_obj(resolver, host, use_tcp: False) -> dns.resolver.Answer :
    """ DNS resolver encapsulates response in Answer object """
    return resolver.resolve(host, 'a', 1, use_tcp)


def print_resolved_hosts(host: str, answers: dns.resolver.Answer) -> None:
    """ Print responses from Answers object """
    logger.debug(host)
    for rdata in answers:
        logger.debug(rdata)
    logger.debug('----------------------')


def blast_resolution(hosts:str, workers:int, use_tcp: bool ) -> None :
    """ DNS blaster core logic """
    with concurrent.futures.ThreadPoolExecutor(max_workers=workers) as executor:
        dns_resolver = dns.resolver.Resolver(configure=True)

        logger.debug(dns_resolver.nameservers)

        future_answers = {}
        for host in hosts:
            future_answers[executor.submit(get_answers_obj, dns_resolver, host, use_tcp)] = host

        for future_answer in concurrent.futures.as_completed(future_answers):
            host = future_answers[future_answer]
            try:
                answers = future_answer.result()
            except Exception as exc:
                logger.error(exc)
            else:
                print_resolved_hosts(host, answers)


def resolve_hosts(domains: list, hosts_count:int, workers:int, iters:int, use_tcp:bool) -> int:
    """ DNS blaster loop """

    hosts = generate_random_host(domains, hosts_count)

    for i in range(iters):
        start = time.time()
        blast_resolution(hosts, workers, use_tcp)
        elapsed_time = (time.time() - start)*1000
        logger.info('iteration: {} - queried {} hosts in {}ms using {} workers'
                    .format(i, hosts_count, elapsed_time, workers))

    return 0

if __name__ == '__main__':
    """ Main function """
    sys.exit(resolve_hosts(DOMAINS, RANDOM_HOSTS_COUNT, WORKER_THREADS, BLASTER_LOOP_COUNT, USE_TCP))
