import controlP5.*;

ControlP5 cp5;
run NAT;
Textarea eventNew;
float interestRate;
float taxBracket;
double[] newBudget=new double[6];
int background=color(140,140,140);
int times=0;
int showSwitch=0;


void draw(){
  background(loadImage("istockphoto-175600020-612x612.jpg"));
    PImage Hap=loadImage("SomethingH.png");
  PImage Sad=loadImage("NothingE.jpg");
  fill(255, 0, 255);
  rect(0, 100, 300, 225);
  fill(0);
  text(NAT.ProcessCondition(), 0, 120);
  if(eventNew.isVisible()&&millis()-times>3000){
    eventNew.hide();
    showSwitch=0;
  }
  System.out.println(showSwitch);
  if(showSwitch==1){
    image(Hap, 300, 300, 100,100);
  }
  if(showSwitch==2){
    image(Sad, 300, 300, 100,100);
  }
}

void setup(){
  String[] eventText = loadStrings("Events.txt");
  Events.eventMaker(eventText);
  PImage image = loadImage("istockphoto-175600020-612x612.jpg");
  background(image);
    size(612,407);
      fill(255, 0, 255);
    rect(0,20, 550, 30);
    fill(0);
  PImage Hap=loadImage("SomethingH.png");
  PImage Sad=loadImage("NothingE.jpg");
  cp5=new ControlP5(this);
    NAT=new run();
  NAT.initializeNation();
  
  cp5.addButton("NextTurn")
    .setPosition(500,200)
    .setSize(100,100)
    .setLabel("Turn End");
  eventNew=cp5.addTextarea("EventNew")
    .setText("Awaiting something")
    .setPosition(300,300)
    .setColor(0)
    .setColorBackground(255)
    .hide();
  cp5.addTextfield("MaxTaxBracket")
    .setPosition(0,0)
    .setSize(70,30)
    //.setRange(0.0,1.0)
    .setText(str((float) NAT.getNation().getMaxTaxBracket()))
    .setLabel("Max Tax Bracket");
  cp5.addTextfield("InterestRate") 
    .setPosition(70,0)
    .setSize(70,30)
    //.setRange(0.0, 3)
    .setText(str((float) NAT.getNation().getInterestRate()))
    .setLabel("Interest Rate")
  ;
  
  cp5.addTextfield("MAN")
    .setPosition(140,0)
    .setSize(70,30)
    //.setRange(0.0, 2.0 * (float) Math.pow(10,10))
    .setText(str((float) NAT.getNation().getGovBudgetBreakDown()[0]))
    .setLabel("Manufacturing");
  cp5.addTextfield("WEL")
    .setPosition(210,0)
    .setSize(70,30)
    //.setRange(0.0, 2.0 * (float) Math.pow(10,10))
    .setText(str((float) NAT.getNation().getGovBudgetBreakDown()[1]))
    .setLabel("Welfare");
  cp5.addTextfield("HEL")
  .setPosition(280,0)
    .setSize(70,30)
    //.setRange(0.0, 2.0 * (float) Math.pow(10,10))
    .setText(str((float) NAT.getNation().getGovBudgetBreakDown()[2]))
    .setLabel("Healthcare");
  cp5.addTextfield("SAL")
   .setPosition(350,0)
    .setSize(70,30)
    //.setRange(0.0, 2.0 * (float) Math.pow(10,10))
    .setText(str((float) NAT.getNation().getGovBudgetBreakDown()[3]))
    .setLabel("Salaries");  
  cp5.addTextfield("MIL")
    .setPosition(420,0)
    .setSize(70,30)
    //.setRange(0.0, 2.0 * (float) Math.pow(10,10))
    .setText(str((float) NAT.getNation().getGovBudgetBreakDown()[4]))
    .setLabel("Military");
  cp5.addTextfield("OTH")
    .setPosition(490,0)
    .setSize(70,30)
    //.setRange(0.0, 2.0 * (float) Math.pow(10,10))
    .setText(str((float) NAT.getNation().getGovBudgetBreakDown()[5]))
    .setLabel("Other");






    
    //Do this for all of them


  //I need nothing ever happens as an image
  //radio button as my event. Super events?
  //
  //
}

void NextTurn(){
    newBudget[0]=(double)cp5.get(Numberbox.class,"MAN").getValue();
    newBudget[1]=(double)cp5.get(Numberbox.class,"WEL").getValue();
    newBudget[2]=(double)cp5.get(Numberbox.class,"HEL").getValue();
    newBudget[3]=(double)cp5.get(Numberbox.class,"SAL").getValue();
    newBudget[4]=(double)cp5.get(Numberbox.class,"MIL").getValue();
    newBudget[5]=(double)cp5.get(Numberbox.class,"OTH").getValue();
    NAT.turn(newBudget,(double)cp5.get(Numberbox.class,"InterestRate").getValue(),(double)cp5.get(Numberbox.class,"MaxTaxBracket").getValue());
    float Happening;
    Happening = random(1);

    System.out.println(Happening);
    if(Happening  < 0.3){
      showSwitch=1;
      Events.EventHappens(NAT.getNation());
      eventNew.setText("Guys, "+Events.getCurrent()).show();

    }
    else{
      showSwitch=2;
      eventNew.setText("Guys, nothing ever happens").show();
    } 
    times=millis();
    }
