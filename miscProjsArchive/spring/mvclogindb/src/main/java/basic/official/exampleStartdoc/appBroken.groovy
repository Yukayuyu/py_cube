@RestController
class Thisdoesnotrun{

    @RequestMapping("/")
    String home() {
        return "Hello, World!";
    }
}