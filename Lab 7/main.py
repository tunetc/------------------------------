import requests
from requests.auth import HTTPBasicAuth

client_id = 'oauth-client'
client_secret = 'oauth-secret'

token_url = 'http://localhost:9090/oauth2/token?grant_type=client_credentials'

response = requests.post(token_url, auth=HTTPBasicAuth(client_id, client_secret))
if response.status_code == 200:
    token = response.json().get('access_token')
    print(f"Токен: {token}")
else:
    print(f"Помилка отримання токена: {response.status_code}, {response.text}")
    token = None

if token:
    articles_url = 'http://localhost:9090/articles'
    headers = {
        'Authorization': f'Bearer {token}'
    }
    response = requests.get(articles_url, headers=headers)
    if response.status_code == 200:
        articles = response.json()
        print(f"Articles: {articles}")
    else:
        print(f"Помилка отримання: {response.status_code}, {response.text}")
