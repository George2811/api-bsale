# Api bsale - Tienda Online
## Funcionamiento
La Api replica una tienda online la cual cuenta con productos agrupados por categorías.
Mediante el uso de esta Api REST podemos filtar productos por categorías, por nombre, o devolver todos los registros existentes.

## Ficha Técnica
Para el desarrollo de esta Api se hizo uso del lenguaje Java, más precisamente del framework Spring Boot.
Se implementó bajo el enfoque de **Domain Driven Design** (DDD), el cual hace énfasis y trabaja alrededor del modelo de negocio. Ello nos permite segmentar el código en capas, la capa **modelo**, la cual contiene todas las clases que reflejan el negocio y, a su vez, encontramos como tablas en la base de datos.
La capa **servicio** nos permitirá implementar la lógica de las funciones que realizará nuestra aplicación. Y finalmente, la capa **controlador**, quién nos permite acceder a esas funcionalidades descritas en ***servicio***, lo que hace que sea la capa más expuesta y cercana al usuario.
En adición a ello, contamos con otras carpetas que servirán de soporte y/o configuración de la app.
Por otro lado, se hizo uso de patrones de diseño tales como el patrón Builder, quién trabaja muy bien con el framework utilizado, y brinda ayuda en la creación de objetos complejos accediendo a ellos mediante unos más simples.
Así como también, la dependencia de ModelMapper, este nos permite crear copias de nuestras clases modelo, que serán usadas por nuestros controladores. De esta forma evitamos exponer nuestra capa dominio, y se apreciará más si la aplicación crece, es decir le damos mayor escalabilidad.
Finalmente, se podrá observar en el código que se mantuvieron las convenciones del lenguaje usado, así como también se priorizaron las buenas prácticas de desarrollo.

## Endpoints
### Product
* **GET All**: Retorna todos los registros de la tabla 'Product'.
* **GET ByCategory**: Retorna todos los productos de la categoría indicada. 
* **GET ByName**: Retorna un producto según el nombre ingresado.

### Category
* **GET All**: Retorna todos los registros de la tabla 'Category'.

## Documentación
Mediante el link podrá acceder a la documentación de la Api elaborado con Swagger, y la app fue desplegada en Heroku.
* link: https://online-store-bsale-api.herokuapp.com/swagger-ui/index.html?configUrl=/bsale-api-docs/swagger-config#/

###### ** ***Nota***: La Api cuenta con paginación y ordenamiento para los endpoints necesarios. Por ello, si solo desea que se retornen los registros sin ningún tipo de estos filtros se debe eliminar el elemento "sort" del objeto *json*, como se muestra a continuación:
![img_delete_sort](https://i.postimg.cc/zXHVf7nn/img-sort.png)
