----------------------------
static-content
----------------------------

1. Describe como poner los contenidos estaticos para que puedan ser accedidos por Spring
2. Muestra como usar librerieas directamente descargandolas o metiendo el webjars como dependencia en el pom para usarlas

----------------------------
thymeleaf
----------------------------
1. Describe como linkar los recursos estaticos como css desde la pagina index.html
2. Describe como usar las plantilla thymeleaf para recoger y mostrar objetos
3. Intenacionalizacion usando i18n simplemente con archivos de tipo message y referencias a ellos en thymeleaf
4. Manejo de errores de excepciones para recogerlas en un controller, tratarlas y mostrarlas en una vista


->ThymeleafApplication => Arranca Spring y ademas implementa un bean con el que redirige el error generico de pagina (404) no encontrada al mapping /404
	|
	|->PostController=> Mapeo ( /posts), 
	|	|		
	|	|->"/inicio" => index
	|	|		
	|	|->"/get/{slug}" => >CustomGenericException 
	|	|		
	|	|->CustomGenericException => views/postError
	|	|		
	|	|->"/" => views/list
	|
	|
	|->CustomErrorController
		|		
		|->"/error" => customError
		|		
		|->"/404" => 404