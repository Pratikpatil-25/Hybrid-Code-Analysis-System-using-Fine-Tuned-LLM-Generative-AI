package dpfmanager.shell.interfaces.gui.component.global.messages;

import dpfmanager.shell.core.messages.DpfMessage;
import dpfmanager.shell.modules.report.util.ReportGui;
import dpfmanager.shell.modules.report.util.ReportIndividualGui;


public class GuiGlobalMessage extends DpfMessage {

  public enum Type {
    INIT, SORT, ADD_INDIVIDUAL, READ
  }

  private Type type;
  private ReportGui reportGui;
  private String vboxId;
  private ReportIndividualGui reportIndividualGui;

    public GuiGlobalMessage(Type t, ReportGui rg) {
    type = t;
    reportGui = rg;
  }

    public GuiGlobalMessage(Type t, String i, ReportIndividualGui rig) {
    type = t;
    vboxId = i;
    reportIndividualGui = rig;
  }

    public GuiGlobalMessage(Type t) {
    type = t;
  }

    public void setType(Type type) {
    this.type = type;
  }

  public boolean isInit(){
    return type.equals(Type.INIT);
  }

  public boolean isRead(){
    return type.equals(Type.READ);
  }

  public boolean isSort(){
    return type.equals(Type.SORT);
  }

  public boolean isAddIndividual(){
    return type.equals(Type.ADD_INDIVIDUAL);
  }

  public ReportGui getReportGui() {
    return reportGui;
  }

  public ReportIndividualGui getReportIndividualGui() {
    return reportIndividualGui;
  }

  public String getVboxId() {
    return vboxId;
  }
}