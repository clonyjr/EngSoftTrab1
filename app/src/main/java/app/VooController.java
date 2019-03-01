package app;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/voos")
public class VooController {
 
    @Autowired
    private IVooRepository vooRepository;
 
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
        Voo retorno = null;
    	try {
			return retorno = vooRepository.findById(id)
			  .orElseThrow(Exception::new);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//VooNotFoundException::new);
    	return retorno;
    }
 
    @PostMapping
    @ResponseStatus//(HttpStatus.CREATED)
    public Voo create(@RequestBody Voo voo) {
        return vooRepository.save(voo);
    }
 
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        try {
			vooRepository.findById(id)
			  .orElseThrow(Exception::new);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//VooNotFoundException::new);
        vooRepository.deleteById(id);
    }
 
    @PutMapping("/{id}")
    public Voo updateVoo(@RequestBody Voo voo, @PathVariable Long id) {
        if (voo.getId() != id) {
          try {
			throw new Exception();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//VooIdMismatchException();
        }
        try {
			vooRepository.findById(id)
			  .orElseThrow(Exception::new);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//VooNotFoundException::new);
        return vooRepository.save(voo);
    }
}