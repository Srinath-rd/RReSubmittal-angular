package com.dnr.brrts.web.model;

import java.io.Serializable;
import java.util.Objects;

public class ReportPersonId implements Serializable
{
   private NfReport report;

   private NfPerson person;

   public ReportPersonId(NfReport report, NfPerson person) {
      this.report = report;
      this.person = person;
   }

   public ReportPersonId() {

   }

   public NfReport getReport() {
      return report;
   }

   public NfPerson getPerson() {
      return person;
   }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ReportPersonId)) return false;
        ReportPersonId reportPersonId = (ReportPersonId) o;
        return Objects.equals(report, reportPersonId.report) &&
                Objects.equals(person, reportPersonId.person);
    }

    @Override
    public int hashCode() {

        return Objects.hash(report, person);
    }
}