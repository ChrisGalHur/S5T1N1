package cat.itacademy.barcelonactiva.GalvezHurtado.Christian.s05.t01.n01.S05T01N01GalvezHurtadoChristian.controllers;


import cat.itacademy.barcelonactiva.GalvezHurtado.Christian.s05.t01.n01.S05T01N01GalvezHurtadoChristian.model.domain.Subsidiary;
import cat.itacademy.barcelonactiva.GalvezHurtado.Christian.s05.t01.n01.S05T01N01GalvezHurtadoChristian.model.services.SubsidiaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SubsidiaryController {

    @Autowired
    private SubsidiaryService subsidiaryService;

    //Muestra lista de sucursales
    @GetMapping("/")
    public String viewHomePage(Model model){
        model.addAttribute("listSubsidiaries", subsidiaryService.getAllSubsidiaries());
        return "index";
    }

    @GetMapping("/showNewSubsidiaryForm")
    public String showSubsidiaryFrom(Model model){
        // Crea atributo de modelo para vincular a la data
        Subsidiary subsidiary = new Subsidiary();
        model.addAttribute("subsidiary", subsidiary);
        return "new_subsidiary";
    }

    @PostMapping("/saveSubsidiary")
    public String saveSubsidiary(@ModelAttribute("Subsidiary") Subsidiary subsidiary){
        // Guardamos la sucursal en la database
        subsidiaryService.saveSubsidiary(subsidiary);
        return "redirect:/";
    }

    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") long id, Model model){
        // Consigue una sucursal de service
        Subsidiary subsidiary = subsidiaryService.getSubsidiaryById(id);

        // Establecemos subsidiary como atributo
        model.addAttribute("subsidiary", subsidiary);
        return "update_subsidiary";
    }

    @GetMapping("/deleteSubsidiaryById/{id}")
    public String deleteSubsidiary(@PathVariable(value = "id") long id){
        this.subsidiaryService.deleteSubsidiaryById(id);
        return "redirect:/";
    }

}












