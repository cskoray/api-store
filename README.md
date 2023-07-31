# Swagger Hub URL
https://app.swaggerhub.com/organizations/CSKORAY_1/projects/zilch-project

# Open API URL
http://localhost:8084/swagger-ui/index.html

# K8s folder has all the yaml files for the deployment
### api-store-deployment.yaml

### Store API
``` 1st step:```

Add new product to store

localhost:8084/v1/api/store/products

```
{
  "name": "Nike air shoes",
  "brand": "Nike",
  "price": 99
}
```
response
```
{
  "id": 3,
  "productKey": "b34e3a88-200b-4ad8-99d4-a9797a7faa94",
  "name": "Nike air shoes",
  "brand": "Nike",
  "price": 99,
  "createdDate": "2023-07-30T11:12:45.664+00:00"
}
```

``` 2st step:```

Register product to ZILCH as brand

localhost:8084/v1/api/store/products/zilch/register
```
{
  "name": "Nike"
}
```
Reponse
```
{
  "status": "success"
}
```