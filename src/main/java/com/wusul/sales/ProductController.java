package com.wusul.sales;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/products")
public class ProductController {
    @Autowired
    ProductRepository repo;

    @GetMapping
    public List<Product> all() {
        return repo.findAll();
    }

    @PostMapping
    public Product add(@RequestBody Product p) {
        return repo.save(p);
    }

    @PostMapping("/{id}/sell")
    public String sell(@PathVariable Long id, @RequestParam int qty) {
        Product p = repo.findById(id).orElseThrow();
        if(p.quantity < qty) return "الكمية غير كافية";
        p.quantity -= qty;
        repo.save(p);
        return "تم البيع";
    }
    
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        repo.deleteById(id);
    }
  }
