# co-orouge
Little Java Game--Battle

A Battle Game between the system-created monster and the player.
Both monster and  player have their own Name,Birth Health,Attack Value and Number of wins. Data stored in the txt files ("player"and "monster") seperartely.
Player also has a spell list which he/she can use. Each spell has a name, a damage range and chance of successful casting. Data stored in the text file "spell".

Play the battle in BattleGame.java, at the beginning of each battle, system shows the information of monster and player, and the spells player can use.
Player attcks first in every round, 
   if player casts the spell she/he learned(listed in spell list), the monster will get attcked by the damage the spell has by its chance and lose corresponding health.
   if player casts the spell not listed in the spell list,player misses this round.
After player attcks, monster will automaticlly attcks in each round.
Battle ends when one of the player of monster get 0 health value, and that side loses. 
The winning side will add 1 to Number of wins in its  file.
