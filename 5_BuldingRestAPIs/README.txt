-----------------------------
rest-starter
-----------------------------
->Es un proyecto simple con una bbdd en memoria h2, un metodo runner para rellenar valores con los que jugar, una interfaz y su servicio que implementara la logica 
y los repositorios para acceder a los POJOS anotados como beans JPA de las tablas Post y Author. Solo que en vez de usar el controlador para redirigir a la capa de
vista lo utilizamos para devolver los metodos http, por lo que es un proyecto de tipo API

->Para cargar los datos tenemos en RestStarterApplication el bean CommandLineRunner que creara un post y un autor y los guardara cuando arranquemos la aplicacion

->Implementa un control de excepciones en caso de que se intente recuperar un post que no existe

->La miga de este proyecto esta en el PostController que es un RestController para mapear los metodos http con la logica de negocio, y tener así una API limpia donde 
llamamos por metodos http y ejecutamos logica de negocio (sin vistas, solo invocacion a metodos http): 

1.Con @RequestMapping( value = "/", method = RequestMethod.GET ) le podemos decir el metodo ademas del mapeo
2.Ademas del metodo del mapeo podemos anotar el parametro a recibir (@RequestBody Post post) para convertir un json object en un objeto Post 
	@RequestMapping( value = "/", method = RequestMethod.POST )
	public Post create(@RequestBody Post post){
		return postService.create(post);
	}

3.El metodo GET es para obtener por lo que le debemos pasar un valor para obtenerlo, en este caso podemos utilizar un variable de path
	@RequestMapping( value = "/{id}", method = RequestMethod.GET )
	public Post read(@PathVariable(value="id") long id){
		return postService.read(id);
	}
4.Para actualizar usamos PUT y le pasaremos lo que teniamos en el 2 (json) y en 3 (parametro)
	@RequestMapping( value = "/{id}", method = RequestMethod.PUT )
	public Post update(@PathVariable(value="id") long id, @RequestBody Post post){
		return postService.update(id,post);
	}


-----------------------------
hypermedia
-----------------------------
->En el proyecto anterior hay que picarse la publicacion de cada recurso. Pero por supuesto Spring ha pensado en esto y ha creado una libreria que permite exponer
todos los recursos para que sean consultados right out of the box. Basta con incluir la dependencia en pom

spring-boot-starter-data-rest

Basta con tener clases anotadas como repositorios y a partir de ese momento todos los objetos
de esos repositorios podran ser consultados directamente con metodos http sin tener que exponer nada

http://localhost:8080/posts/1

->Es interesante la clase PagingAndSortingRepository que hereda de CrudRepository y que ademas añade las caracteristicas de paginacion (siguiente y anterior) y tamaño

->Tambien se incluye el concepto de projection que no es mas que un subset de un objeto, para exponer solo las cosas que interesan. Para ello nos creamos una intefaz 
que anotamos como @Projection( name="teaser", types = {Post.class} ). Si queremos llamar a este subset de un objeto basta con poner

http://localhost:8080/posts/1?projection=teaser

->Ademas tenemos una utilidad espectacular para hacer tests de los metodos expuestos en nuestra API. Basta con incluir la dependencia en pom

spring-data-rest-hal-browser

Una vez hecho en la url http://localhost:8080/ tendremos un navegador que nos permitira ver todos los recursos expuestos y jugar con ellos

-----------------------------
rest template
-----------------------------
->En los otros proyectos hemos aprendido a exponer nuestros recursos, pero no sabemos como consumir recursos externos. Podemos hacerlo invocando con httprequest, creando
todo el mapeo de los objetos, pero para simplificar todo eso spring ha creado las rest template

->En el fichero de static tenemos un weather.json que por defecto spring publicara en http://localhost:8080/data/weather.json y que sera el recurso que consumiremos. 
Basta con poner:

	RestTemplate restTemplate = new RestTemplate();
    	Weather weather = restTemplate.getForObject("http://localhost:8080/data/weather.json", Weather.class);

Estamos utilizando el metodo getForObject de un recurso externo publicado (aunque en este caso sea el nuestro). La clase RestTemplate es la que tiene toda la logica
para consumir recursos y tiene cantidad de metodos que permite jugar con ellos