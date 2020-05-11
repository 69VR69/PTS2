package fr.iut.orsay.pts2.ai;

import fr.iut.orsay.pts2.Civilization;

public class AI extends Civilization
    {
      /*  public AI(String name, String description, Unit unit, ArrayList<Building> buildings, ArrayList<Relationship> relationships)
            {
                super(name, description, unit, buildings, relationships);
            }
        
        public boolean Action()
            {
                boolean result = false;
                
                try
                    {
                        Diplomacy();
                        Technology();
                        Buildings();
                        Units();
                        result = true;
                    }
                catch (Exception e) //TODO: specify exception type
                    {
                        System.out.println("Error: " + e.getCause());
                    }
                
                
                return result;
            }
        
        private void Diplomacy()
            {
                for (Relationship r : this.getRelationships())
                    {
                        switch (r.getRelationStep())
                            {
                                case 'F':
                                    if (Tools.getLuck(CONSTANT.FRIEND_RESSOURCE))
                                        {
                                            r.trade();//TODO: add offer and demand arraylist
                                        }
                                    break;
                                case 'G':
                                    if (Tools.getLuck(CONSTANT.GOODFRIEND_ALLIANCE))
                                        {
                                            r.alliance();
                                        }
                                    if (Tools.getLuck(CONSTANT.GOODFRIEND_RESSOURCE))
                                        {
                                            r.trade();//TODO: add offer and demand arraylist
                                        }
                                    break;
                                case 'A':
                                    if (Tools.getLuck(CONSTANT.ALLIANCE_COMMONWAR))
                                        {
                                            r.trade();//TODO: add an ennemie
                                        }
                                    if (Tools.getLuck(CONSTANT.ALLIANCE_RESSOURCE))
                                        {
                                            r.trade();//TODO: add offer and demand arraylist
                                        }
                                    break;
                                case 'W':
                                    if (Tools.getLuck(CONSTANT.WAR_PEACE))
                                        if (r.trade())
                                            r.setRelationStep('E');
                                    break;
                                case 'E':
                                    if (Tools.getLuck(CONSTANT.ENNEMIE_WAR))
                                        {
                                            r.war();
                                        }
                                    break;
                                default:
                                    break;
                            }
                        
                    }
            }
        
        private void Buildings()
            {
                needRessource().upgrade();
            }
        
        private void Units()
            {
            
            }
        
        private void Technology()
            {
                System.out.println("technology");
            }
        
        private Building needRessource()//TODO: change stock by rate + add this.getBuildings().      getRessourceDistrict        .get(0)
        {
            Building temp = this.getBuildings().get(0);
            for (Building b : this.getBuildings())
                {
                    if (b.getStock() == temp.getStock())
                        temp = (Building) Tools.chooseBetween(b, temp);
                    else if (b.getStock() < temp.getStock())
                        temp = b;
                }
            return temp;
        }
        
        private void createUnit()
            {
                Unit[] units = {new Boat("Boat"), new Soldier("Soldier"), new Soldier("Soldier")};
                ArrayList<Unit> listOfUnits = new ArrayList<>(Arrays.asList(units));
                Unit newUnit;
                
                if (isWar())
                    {
                        Civilization targetCiv = (Civilization) Tools.chooseBetween((Object) listCiv().toArray(new Civilization[0]));
                        newUnit = targetCiv.mostTroop();
                        if (Tools.getLuck(CONSTANT.OPTI_UNIT_CREATE))
                            {
                                //TODO: create this unit (newUnit)
                            }
                        else
                            {
                                listOfUnits.remove(newUnit);
                                newUnit = (Unit) Tools.chooseBetween((Object) listOfUnits.toArray(new Unit[0])); //TODO: create this unit
                            }
                    }
                else
                    {
                        newUnit = (Unit) Tools.chooseBetween((Object) listOfUnits.toArray(new Unit[0]));
                        if (newUnit.getName().equals(mostTroop().getName()))
                            {
                                listOfUnits.remove(newUnit);
                                newUnit = (Unit) Tools.chooseBetween((Object) listOfUnits.toArray(new Unit[0])); //TODO: create this unit
                            }
                        //else
                        //TODO: create this unit (newUnit)
                    }
            }
        
        private void moveUnit()
            {
                if (isWar())
                    {
                        //warMovement(this.listCivByRelationship('W').toArray(new Civilization[0]));
                    }
                else
                    {
                        safeMovement();
                    }
            }
        
        private void safeMovement() {
               // Unit uTest = new Soldier("Jean");
                if (true/*une troupe viens d'être créer)
                    {
                       /* while (!uTest.nextBorder(CONSTANT.WILDLAND))
                            {
                                int nextPos = (int) Tools.chooseBetween(1, 2, 3, 4, 5, 6, 7, 8);
                                switch (nextPos)
                                    {
                                        case 1:
                                            uTest.move(0, 1);
                                            break;
                                        case 2:
                                            uTest.move(1, 1);
                                            break;
                                        case 3:
                                            uTest.move(1, 0);
                                            break;
                                        case 4:
                                            uTest.move(1, -1);
                                            break;
                                        case 5:
                                            uTest.move(0, -1);
                                            break;
                                        case 6:
                                            uTest.move(-1, -1);
                                            break;
                                        case 7:
                                            uTest.move(-1, 0);
                                            break;
                                        case 8:
                                            uTest.move(-1, 1);
                                            break;
                                        default:
                                            System.out.println("Error nextPos invalid number");
                                            break;
                                    }
                                if (uTest.getMovementPoint() <= 0)
                                    {
                                        for (Unit u : this.getUnitList())
                                            {
                                                if (u.moveOn(CONSTANT.WILDLAND))
                                                    break;
                                                
                                            }
                                    }
                            }
                    }
            }
        
        private void warMovement(Civilization... civilizations)
            {
                /*
                class Ennemy:
                    weight = {
                            "archer": 2,
                            "soldat": 3,
                            "chevalier": 5
                            }

                    def __init__(self, ennemyNumber, x, y): contructeur
                        """
                            parameter:
                            ennemyNumber: dict of ennemy number
                            example:
                            {"archer": 3, "soldat": 2}²
                        """
                        self.weight = self._initWeight(ennemyNumber)
                        self.x = x
                        self.y = y
                        self.depressionRate = 0.2
    
                    def _initWeight(self, ennemyNumber): methode private
                        weight = 0

                        for types, number in ennemyNumber.items():
                            weight += number * Ennemy.weight[types]
        
                        return weight

                class Board:

                    def __init__(self, height, width):
                        self.height = height
                        self.width = width
                        self.board = [[0 for x in range(width)] for y in range(height)]
    
                    def getTacticalBoard(self, ennemies):
                        output = [[0 for x in range(self.width)] for y in range(self.height)] rempli tableau 2D de 0

                        for ennemi in ennemies:
                            for y in range(self.height):
                                for x in range(self.width):
                                    deltaX, deltaY = abs(ennemi.x - x), abs(ennemi.y - y)
                                    output[y][x] += ennemi.weight - (ennemi.weight * (deltaX + deltaY) * ennemi.depressionRate)
                    return output
    
                @staticmethod
                    def displayBoard(board):
                        for line in board:
                            for element in line:
                                print("{:5}".format(round(element, 2)), end=" ")
                                print()
    
               class Game:

                    def __init__(self):
                        self.Ennemy = [] # list qui contient tout les ennemies
    

                        test = Ennemy({"archer": 3, "soldat": 2}, 2, 2)
                        test2 = Ennemy({"archer": 3, "soldat": 2}, 3, 3)
                        board = Board(10, 10)

                Board.displayBoard(board.getTacticalBoard([test, test2]))
                
            }*/
    }
