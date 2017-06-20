----------------------
h2demo
----------------------
aplicacion sencilla sin parte web que arranca una bbdd en memoria con dos clases de dominio Author y Post. Cuando arranca spring
se carga el servicio dataloader que tiene los interfaces de repositorio de tipo crud de las clases author y post y que ejecuta un metodo
justo despues de ejecutar el constructor para crear un autor y post. Puedes verlos desde la consola de h2 pero una vez que se apague se
borraran


----------------------
blogrefactor
----------------------
Aplicacion web con estilos, thymeleaf, y acceso a bbdd con jpa. La arquitectura es tal y como deberían crearse las aplicaciones:
1.Clase de arranque de spring boot
2.Carpeta Controler para los mapeos. Tendra inyectados con autowired los servicios que quiere utilizar. Lo lógico sería que un metodo de mapeo del controler
invocase a un metodo de un servicio para llevar a cabo la lógica necesaria que debe ser realizada para mostrar la vista
3.Carpeta Servicios cuyas clases tendran los metodos que contendran la logica de negocio. Todo le java duro
4.Carpeta Repository con las interfaces crud de las entidades involucradas
5.Carpeta Domain con las entidades de negocio (POJO) que estarán linkadas por jpa a tablas de BBDD
El flujo lógico sería:
view->controller->servicio->repostory->domain->BBDD

La aplicacion esta configurada con la BBDD h2 para local y postresql para produccion. Tienes queries usando jpa y hibernate y tan bien como lanzar queries directamente
utilizando las anotaciones

Ponemos el logback.xml para que se habilite el log de hibernate y sepamos que query lanzamos usando los metodos de jpa de spring