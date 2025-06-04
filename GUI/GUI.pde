import controlP5.*;

ControlP5 cp5;
run NAT;
Textlabel eventNew;
float interestRate;
float taxBracket;
double[] newBudget=new double[6];
int background=color(255,255,255);

void draw(){
  text(run.ProcessCondition(), 300, 200);
}

void setup(){
  size(700,500);
  cp5=new ControlP5(this);
  cp5.addButton("NextTurn")
    .setPosition(300,300)
    .setSize(50,50)
    .setLabel("Turn End");
  eventNew=cp5.addTextlabel("EventNew")
    .setText("Awaiting something")
    .setPosition(300,300)
    .hide();
  cp5.addNumberbox("MaxTaxBracket")
    .setPosition(0,0)
    .setSize(70,60)
    .setRange(0.0,1.0)
    //.setValue();
    .setLabel("Max Tax Bracket");
  cp5.addNumberbox("InterestRate")
    .setPosition(70,0)
    .setSize(70,60)
    .setRange(0.0,1.0)
    //.setValue();
    .setLabel("Interest Rate");
  cp5.addNumberbox("MAN")
    .setPosition(140,0)
    .setSize(70,60)
    //.setRange()
    //.setValue();
    .setLabel("Manufacturing");
  cp5.addNumberbox("WEL")
    .setPosition(210,0)
    .setSize(70,60)
    //.setRange()
    //.setValue();
    .setLabel("Welfare");
  cp5.addNumberbox("HEL")
    .setPosition(280,0)
    .setSize(70,60)
    //.setRange()
    //.setValue();
    .setLabel("Healthcare");
  cp5.addNumberbox("SAL")
    .setPosition(350,0)
    .setSize(70,60)
    //.setRange()
    //.setValue();
    .setLabel("Saleries");  
  cp5.addNumberbox("MIL")
    .setPosition(420,0)
    .setSize(70,60)
    //.setRange()
    //.setValue();
    .setLabel("Military");
  cp5.addNumberbox("OTH")
    .setPosition(490,0)
    .setSize(70,60)
    //.setRange()
    //.setValue();
    .setLabel("Other");
    
    //Do this for all of them

  
    
  NAT=new run();
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

void draw(){
  background(background);
}
