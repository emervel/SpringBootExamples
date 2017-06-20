---------------------------
initial
---------------------------
->El proyecto inicial del que partimos es una aplicacion tipica de mvc de blog con entidades de tipo author y post que tienen los correspondientes repositorios, servicios y
controladores. Tiene una bbdd h2 que se carga automaticamente usando el componente LoaderData.

->Implementa seguridad en SecurityConfig (usando WebSecurityConfigurerAdapter) para autentificacion y autorizacion. Y usa seguridad a nivel de templates usando los tags sec:authorize="hasRole('ROLE_ADMIN')"

->Es interesante el elemento de configuracion WebConfig donde establece
	-La vista controlador login para saber a donde debe redigir en caso de que no este logado
	-Un interceptor propio llamado BaseInterceptor que sobrescribe el metodo postHandle para anadirle a todas las modelAndView que usemos el nombre del controlador que las ha 
	tratado y el nombre de la accion http utilizada (asi nos evitamos poner este codigo en todos y cada uno de los mapeos de los controladores) para poder usarlos en las templates

---------------------------
crud-read
---------------------------
->Hemos partido del anterior y le hemos ido anadiendo las funcionalidades para el usuario admin. No hay mucho que explicar porque se hace como siempre en un controlador
y pasando al las templates los model con los datos que queremos. 

->Es interesante la parte de validacion porque hemos anotado los campos del POJO de dominio que queremos validar, de modo que:
	-En el controler basta con anotar tb parametro del bean para que valide
		@Valid Post post, BindingResult bindingResult, Model model
	-En el controlador tendremos el siguiente metodo para ver si tenemos errores 
		bindingResult.hasErrors()
	-En las templates usaremos lo siguiente para mostrarlos
		<div th:class="form-group" th:classappend="${#fields.hasErrors('title')}? 'has-error'">
	-Podemos personalizar los errores a mostrar usando el recurso message.properties
		NotEmpty.post.title=Mete un titulo alma de cantaro

->De la parte de edicion de un post es curioso que para hacerlo basta con poner en la template una variable hidden y mandarle el post recuperado
	<input type="hidden" th:field="*{id}" />

->En el borrado podemos utilizar los RedirectAttributes que son como request atributes para pasar los valores que queramos tener en la vista
	redirectAttributes.addFlashAttribute("message", "Post was deleted");
  Hay que distinguir entre redirigir y mandar a la vista. En la redireccion tu estas pasando por controlador con el mapping mientras que si solo ponemos la vista nos 
  saltamos el controlador por lo que en metodos como borrado perderiamos los datos que el controlador recupera para la vista


---------------------------
spring-boot-thymeleaf-fragment-ajax
---------------------------
Este proyecto lo he descargado de 
http://dmunozfer.es/fragmentos-en-thymeleaf-con-spring-boot-y-ajax/

Es un ejemplo de ajax con spring y thymeleaf donde una lista desplegable se carga a partir de los valores de otra