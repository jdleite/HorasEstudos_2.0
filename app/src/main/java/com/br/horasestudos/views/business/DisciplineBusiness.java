package com.br.horasestudos.views.business;

import com.br.horasestudos.views.entity.Discipline;
import com.br.horasestudos.views.repository.DisciplineRepository;

import java.util.List;

public class DisciplineBusiness {

    DisciplineRepository repository = new DisciplineRepository();

    public Boolean saveDiscipline(Discipline discipline){
        return repository.saveDiscipline(discipline);
    }

    public List<Discipline> listDiscipline(){
        return repository.listDiscipline();
    }

    public Boolean updateDiscipline(Discipline discipline){
        return repository.updateDiscipline(discipline);

    }

    public Boolean removeDiscipline(int id){
        return repository.removeDiscipline(id);
    }

    public Discipline loadDiscipline(int id){
        return repository.loadDiscipline(id);
    }

    public int sumHour(int begin,int finish){

        return  begin - finish;


    }
}
