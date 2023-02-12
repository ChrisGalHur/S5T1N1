package cat.itacademy.barcelonactiva.GalvezHurtado.Christian.s05.t01.n01.S05T01N01GalvezHurtadoChristian.model.services;

import cat.itacademy.barcelonactiva.GalvezHurtado.Christian.s05.t01.n01.S05T01N01GalvezHurtadoChristian.model.domain.Subsidiary;
import cat.itacademy.barcelonactiva.GalvezHurtado.Christian.s05.t01.n01.S05T01N01GalvezHurtadoChristian.model.dto.SubsidiaryDTO;

import java.util.List;

public interface SubsidiaryService {

    List<SubsidiaryDTO> getAllSubsidiaries();

    void saveSubsidiary(Subsidiary subsidiary);

    Subsidiary getSubsidiaryById(long id);

    void deleteSubsidiaryById(long id);
}
