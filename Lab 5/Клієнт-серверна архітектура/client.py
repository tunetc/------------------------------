import socket

def start_client(host='127.0.0.1', port=1596):
    with socket.socket(socket.AF_INET, socket.SOCK_STREAM) as s:
        s.connect((host, port))
        message = "Привіт з сервера"
        s.sendall(message.encode())
        data = s.recv(1024)
        print(f"Відправлено з сервера: {data.decode()}")

if __name__ == "__main__":
    start_client()
