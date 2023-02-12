package cat.itacademy.barcelonactiva.GalvezHurtado.Christian.s05.t01.n01.S05T01N01GalvezHurtadoChristian.model.services;

import cat.itacademy.barcelonactiva.GalvezHurtado.Christian.s05.t01.n01.S05T01N01GalvezHurtadoChristian.model.domain.Subsidiary;
import cat.itacademy.barcelonactiva.GalvezHurtado.Christian.s05.t01.n01.S05T01N01GalvezHurtadoChristian.model.dto.SubsidiaryDTO;
import cat.itacademy.barcelonactiva.GalvezHurtado.Christian.s05.t01.n01.S05T01N01GalvezHurtadoChristian.model.repository.SubsidiaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SubsidiaryServiceImpl implements SubsidiaryService {

    @Autowired
    private SubsidiaryRepository subsidiaryRepository;

    @Override
    public List<SubsidiaryDTO> getAllSubsidiaries() {
        return subsidiaryRepository.findAll().stream().map(this::convertEntityToDTO).collect(Collectors.toList());
    }

    private SubsidiaryDTO convertEntityToDTO(Subsidiary subsidiary) {
        SubsidiaryDTO sucursalDTO = new SubsidiaryDTO(subsidiary.getId(), subsidiary.getName(), subsidiary.getCountry(), subsidiary.getCountry());
        return sucursalDTO;
    }

    @Override
    public void saveSubsidiary(Subsidiary subsidiary) {
        this.subsidiaryRepository.save(subsidiary);
    }

    @Override
    public Subsidiary getSubsidiaryById(long id) {
        Optional<Subsidiary> optional = subsidiaryRepository.findById(id);
        Subsidiary subsidiary = null;
        if(optional.isPresent()){
            subsidiary = optional.get();
        }else {
            throw new RuntimeException("Subsidiary not found for id: " + id);
        }
        return subsidiary;
    }

    @Override
    public void deleteSubsidiaryById(long id) {
        this.subsidiaryRepository.deleteById(id);
    }










}
