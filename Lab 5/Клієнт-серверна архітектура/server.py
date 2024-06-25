import socket

def start_server(host='127.0.0.1', port=1596):
    with socket.socket(socket.AF_INET, socket.SOCK_STREAM) as s:
        s.bind((host, port))
        s.listen()
        print(f"Сервер запущено {host}:{port}")
        conn, addr = s.accept()
        with conn:
            print(f"Під'єднано {addr}")
            while True:
                data = conn.recv(1024)
                if not data:
                    break
                print(f"Привіт від клієнта {data} from client")
                conn.sendall(data)  # Echo back the received data

if __name__ == "__main__":
    start_server()
