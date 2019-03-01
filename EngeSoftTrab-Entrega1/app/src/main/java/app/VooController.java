@RestController
@RequestMapping("/api/voos")
public class VooController {
 
    @Autowired
    private VooRepository vooRepository;
 
    @GetMapping
    public Iterable findAll() {
        return vooRepository.findAll();
    }
 
    @GetMapping("/title/{vooTitle}")
    public List findByTitle(@PathVariable String vooTitle) {
        return vooRepository.findByTitle(vooTitle);
    }
 
    @GetMapping("/{id}")
    public Voo findOne(@PathVariable Long id) {
        return vooRepository.findById(id)
          .orElseThrow(VooNotFoundException::new);
    }
 
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Voo create(@RequestBody Voo voo) {
        return vooRepository.save(voo);
    }
 
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        vooRepository.findById(id)
          .orElseThrow(VooNotFoundException::new);
        vooRepository.deleteById(id);
    }
 
    @PutMapping("/{id}")
    public Voo updateVoo(@RequestBody Voo voo, @PathVariable Long id) {
        if (voo.getId() != id) {
          throw new VooIdMismatchException();
        }
        vooRepository.findById(id)
          .orElseThrow(VooNotFoundException::new);
        return vooRepository.save(voo);
    }