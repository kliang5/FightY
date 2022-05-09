# co-orouge
Little Java Game--Battle

Systematically created head-to-head game between monsters and players. Both monsters and players have their own names, birth health, attack values and number of wins. The data is stored in txt files ("player" and "monster") respectively. Players also have a list of available spells. Each spell has a name, damage range and chance of success, which is stored in the txt file "spell".

Battles are fought in Battle.java, and at the beginning of each battle, the system displays information about the monster and the player, as well as the spells the player can use. The player attacks first each turn, and if the player casts a spell she/he has learned (listed in the spell list), the monster is attacked for the damage taken by that spell and loses the corresponding amount of life. If a player casts a spell that is not listed in the spell list, that player will miss the turn. After the player attacks, the monster will automatically attack each round. The battle ends when one of the monsters' player's life value becomes 0. The party with 0 life value loses. The winning party will add 1 to the number of wins in their file.

