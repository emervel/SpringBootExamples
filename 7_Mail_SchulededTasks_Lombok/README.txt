------------------------------
sending-email
------------------------------
Para enviar un mail basta con usar:
-> En el pom la dependencia
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-mail</artifactId>
		</dependency>
-> En el aplication properties la configuracion del mail
spring.mail.host = smtp.gmail.com
spring.mail.username = xxx@gmail.com
spring.mail.password = xxxxxxxxxxxxx
spring.mail.port=587
spring.mail.properties.mail.smtp.starttls.enable = true

-> En el servicio que lo invoca
		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo(user.getEmailAddress());
		mail.setFrom("danvega@gmail.com");
		mail.setSubject("Toys for Shots is coming soon!");
		mail.setText("This is a cool email notificaiton");
		
		javaMailSender.send(mail);

-> Adicionalmente para hacer logging en cada clase basta con definir un atributo Logger y luego ya podemos usar el metodo de log que queramos
	private Logger logger = LoggerFactory.getLogger(RegistrationController.class);
	logger.info("Errrrrrroooor");


----------------------------------
schedule-tasks\gs-scheduling-tasks\initial
----------------------------------
Para planificar una tarea podemos utilizar:

->la anotacion @EnableScheduling en la clase que arranca spring

->la anotacion @Scheduled(fixedRate = 5000) para indicar que una tarea se ha planificado para ejecutarse cada 5 segundos (la clase esta anotada como un componente para que spring lo identique en el arranque)

    @Scheduled(fixedRate = 5000)
    public void reportCurrentTime() {
        log.info("The time is now {}", dateFormat.format(new Date()));
    }


------------------------------------------------
lombok
------------------------------------------------
Es una dependencia que evita tener que picar los getter,setter, hashcode, equals, etc de las clases POJO que usamos como entidades de dominio. Basta con poner:
-> En el pom incluir la dependencia 
		<dependency>
			<groupId>org.projectlombok</groupId>
			<artifactId>lombok</artifactId>
			<optional>true</optional>
		</dependency>
-> En el POJO, anotar como @Data

Con la anotacion @Data tenemos todo (getter, setter, equals..) pero si solo lo queremos para un atributo, anotamos ese atributo
@Getter @Setter
