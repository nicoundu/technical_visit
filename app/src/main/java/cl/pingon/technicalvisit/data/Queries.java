package cl.pingon.technicalvisit.data;

import java.util.ArrayList;
import java.util.List;

import cl.pingon.technicalvisit.models.Visit;

public class Queries {

    public List<Visit> visits() {

        List<Visit> visits = new ArrayList<>();
        List<Visit> visitList = Visit.listAll(Visit.class);

        if (visitList != null && visitList.size() > 0) {

            visits.addAll(visitList);
        }

        return visits;
    }
}
