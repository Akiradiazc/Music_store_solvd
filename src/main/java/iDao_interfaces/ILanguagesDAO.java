package iDao_interfaces;

import Model.Languages;

import java.util.List;

public interface ILanguagesDAO {
    // ------ CREATE
    boolean create(Languages language);

    // ------ READ
    List<Languages> getAllLanguages();
    Languages getLanguageById(int idLanguage);

    // ------ UPDATE
    boolean update(Languages language);

    // ------ DELETE
    boolean delete(Languages language);
}
