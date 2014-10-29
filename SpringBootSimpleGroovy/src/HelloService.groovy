
@RestController
class HelloService {

    @RequestMapping("/")
    String sayHello() {
        "Hello World!"
    }
}
