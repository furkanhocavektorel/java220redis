# Projeyi çalıştırmak için gerekli olan adımlar

## application.yml
* database bilgilerinizi application.yml dosyasına ekleyin.

## Redis Kurulumu
* Redis'i kurmak için aşağıdaki adımları izleyin:
* Docker'ı indirin ve kurun.
* Docker'ı başlatın.
* Aşağıdaki komutu terminalde çalıştırarak Redis'i başlatın:
```
docker run --name redis -p 6380:6379 -d redis
```
* redis kurulumu tamamlandıktan sonra redis'e bağlanmak için:
  * host: localhost
  * port: 6380
  * database: 0 veya yazmayın.
  * security: noAuth
