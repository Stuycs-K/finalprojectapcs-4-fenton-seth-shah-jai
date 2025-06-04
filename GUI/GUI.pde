import controlP5.*;

ControlP5 cp5;
run NAT;
Textlabel eventNew;
float interestRate;
float taxBracket;
double[] newBudget=new double[6];
int background=color(255,255,255);

void draw(){
  background(background);
  fill(100);
  text(NAT.ProcessCondition(), 0, 120);
}

void setup(){
  size(700,500);
  cp5=new ControlP5(this);
    NAT=new run();
  NAT.initializeNation();
  cp5.addButton("NextTurn")
    .setPosition(500,200)
    .setSize(100,100)
    .setLabel("Turn End");
  eventNew=cp5.addTextlabel("EventNew")
    .setText("Awaiting something")
    .setPosition(300,300)
    .hide();
  cp5.addNumberbox("MaxTaxBracket")
    .setPosition(0,30)
    .setSize(70,60)
    .setRange(0.0,1.0)
    .setValue((float) NAT.getNation().getMaxTaxBracket())
    .setLabel("Max Tax Bracket");
  cp5.addNumberbox("InterestRate") 
    .setPosition(70,30)
    .setSize(70,60)
    .setRange(0.0, 3)
    .setValue((float) NAT.getNation().getInterestRate())
    .setLabel("Interest Rate")
  ;
  
  cp5.addNumberbox("MAN")
    .setPosition(140,30)
    .setSize(70,60)
    .setRange(0.0, 2.0 * (float) Math.pow(10,10))
    .setValue((float) NAT.getNation().getGovBudgetBreakDown()[0])
    .setLabel("Manufacturing");
  cp5.addNumberbox("WEL")
    .setPosition(210,30)
    .setSize(70,60)
    .setRange(0.0, 2.0 * (float) Math.pow(10,10))
    .setValue((float) NAT.getNation().getGovBudgetBreakDown()[1])
    .setLabel("Welfare");
  cp5.addNumberbox("HEL")
  .setPosition(280,30)
    .setSize(70,60)
    .setRange(0.0, 2.0 * (float) Math.pow(10,10))
    .setValue((float) NAT.getNation().getGovBudgetBreakDown()[2])
    .setLabel("Healthcare");
  cp5.addNumberbox("SAL")
   .setPosition(350,30)
    .setSize(70,60)
    .setRange(0.0, 2.0 * (float) Math.pow(10,10))
    .setValue((float) NAT.getNation().getGovBudgetBreakDown()[3])
    .setLabel("Salaries");  
  cp5.addNumberbox("MIL")
    .setPosition(420,30)
    .setSize(70,60)
    .setRange(0.0, 2.0 * (float) Math.pow(10,10))
    .setValue((float) NAT.getNation().getGovBudgetBreakDown()[4])
    .setLabel("Military");
  cp5.addNumberbox("OTH")
    .setPosition(490,30)
    .setSize(70,60)
    .setRange(0.0, 2.0 * (float) Math.pow(10,10))
    .setValue((float) NAT.getNation().getGovBudgetBreakDown()[5])
    .setLabel("Other");






    
    //Do this for all of them


  //I need nothing ever happens as an image
  //radio button as my event. Super events?
  //
  //
}

void NextTurn(){
    //System.out.println("{ressed");
    newBudget[0]=(double)cp5.get(Numberbox.class,"MAN").getValue();
    newBudget[1]=(double)cp5.get(Numberbox.class,"WEL").getValue();
    newBudget[2]=(double)cp5.get(Numberbox.class,"HEL").getValue();
    newBudget[3]=(double)cp5.get(Numberbox.class,"SAL").getValue();
    newBudget[4]=(double)cp5.get(Numberbox.class,"MIL").getValue();
    newBudget[5]=(double)cp5.get(Numberbox.class,"OTH").getValue();
    NAT.turn(newBudget,(double)cp5.get(Numberbox.class,"InterestRate").getValue(),(double)cp5.get(Numberbox.class,"MaxTaxBracket").getValue());
    eventNew.setText("Guys, "+Events.getCurrent()).show();
    delay(4000);
    eventNew.hide();
    
}
