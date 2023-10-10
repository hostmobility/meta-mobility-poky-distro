import socket
import subprocess
import time
import multiprocessing
import os

def check_unit_connection(hostname):
    try:
        ip_address = socket.gethostbyname(hostname)
        subprocess.check_output(["ping", "-c", "1", ip_address])
        return True
    except (subprocess.CalledProcessError, socket.gaierror):
        return False

def write_status_to_file(hostname, online):
    directory = "/tmp/MobilityProductionTest/"
    os.makedirs(directory, exist_ok=True)  # Create the directory if it doesn't exist
    filename = f"{directory}status_{hostname}"
    with open(filename, "w") as file:
        file.write("Online" if online else "Offline")

def monitor_host(hostname, interval):
    while True:
        online = check_unit_connection(hostname)
        write_status_to_file(hostname, online)
        time.sleep(interval)

if __name__ == "__main__":
    hostnames = ["dut_usb", "mxv_eth0", "google.com"]
    check_interval = 10  # Check every 10 seconds

    processes = []
    for hostname in hostnames:
        process = multiprocessing.Process(target=monitor_host, args=(hostname, check_interval))
        process.daemon = True
        process.start()
        processes.append(process)

    try:
        for process in processes:
            process.join()
    except KeyboardInterrupt:
        pass
