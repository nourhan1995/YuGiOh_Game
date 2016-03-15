# YuGiOh_Game

# 1 Game Description
Yu Gi Oh is a trading card game where 2 players battle each other with their monster and spells. The
objective of the game is to make your opponent lose her life points or finish her cards. In this project you
will implement a simplified version of the original game. Please note that the rules of the proposed
game are different than the rules of the original game.

# 1.1 Game Setup
# 1.1.1 Cards

There are 2 types of cards to play the turns and indicate the allowed actions of the game (monsters
and spells). The rules of using the cards are described in details in section 5.1. The collection of the
cards available in the game are provided in 2 CSV database files. There are 40 cards in the game: 30
monsters and 10 spells.
#Monsters
These are your main cards (See Fig 2). There are 30 available monsters in the game. Each monster has
4 main values to define it: 2 Power value, mode and level.

• Power values: The values define the strength of the monster. Each monster has an attacking
power and defense power.

•Mode: The mode specifies which power value should be used to indicate the strength of the
monster and whether you are allowed to attack your opponent with the monster or not. Possible
modes are: ATTACK and DEFENSE. According to the active mode, the respective power is
used. Putting a monster in an attack mode is called “Summoning” a monster. On the other hand,
putting a monster in a defense mode is called “Setting” a monster.

• Level: It indicates whether you can add the monster directly in the field slot or you need to
sacrifice another monster to use it. “Sacrifice” means sending a monster from the field to the
graveyard (Rules in section 2.1.5). A monster is sent to (discarded in) the graveyard when it is
destroyed (in battle or by effect card) or you sacrifice it.

#Spells
This is considered as an effect card. An effect card can do an action that affects the monsters or the
turn mechanics. The effect of the spell card is specified by the card description. There are 10 available
spells in the game.
Example 2 A spell card for increasing the attacking power of a monster

• Using a spell card to do its action whether from your hand (See section 2.1.3) or the field is called
”activation”. However, adding the spell card to the field in a passive way to use it later turns is
called ”Setting” the card.

• A spell card is discarded in the graveyard once it is used (activated).

#1.1.2 Deck
Each player has a deck. A deck is a collection of 20 unseen cards provided by the computer per player.
The cards of the deck are chosen randomly from the collection of cards in the game. The deck must have
15 monsters and 5 spells. The deck must be shuffled in the beginning of the game. The deck is your
source of cards during the turns whenever you need to draw more cards.
#1.1.3 Hand Deck
Each player has some cards in his hands. You are only allowed to use these cards to add new cards to
the field. You start the game by drawing 5 cards from the top of a shuffled deck and draw an extra card
per turn.
#1.1.4 Field slots
Field slots represent the card locations of the player on the game board. Each player can have in the
field a maximum of 5 monsters and 5 spells at a time. You are only allowed to use this collection of
cards during the turns.
#1.1.5 Graveyard
A pile for discarding dead cards. A card is discarded whenever it is destroyed in the field or sacrificed
or activated depending on the card type. Some spell cards can retrieve dead cards.
#1.1.6 Field and Game Board
Each player has a field. The field is composed of her Deck, hand deck, field slots and graveyard. The
fields of both players build the game board.

#2 How Does the Game Start?
1. The board is empty. Each player has 5 empty slots for monsters and 5 empty slots for spells, a
graveyard and a shuffled deck of 20 cards.

2. Each player has 8000 life points.

3. Each player draws the first 5 cards from their respective deck.

4. The PC chooses randomly the player who should start.

5. The starting player should draw 1 extra card.

#3 How Does the Game End?
The game ends whenever any of the following 2 states is reached:

1. The life points of a player is 0. Thus, her opponent is the winner.

2. The player attempts to draw a card from his empty deck. Thus, her opponent is the winner.

Example 3 Player (A) drew the last card in this turn. The deck is currently empty. The player
will continue this turn normally. Once she tries to draw a card the next turn, she will lose and
Player (B) will win.

#4 Turn Mechanics
The active player starts the turn by drawing 1 card from the hidden top of the deck. The objective of
the turn is to make your opponent lose from her life points and protect your own. A turn is divided into
3 main stages that will be discussed in details in the following sections:

1. Main (1) phase: Prepare yourself for this turn’s battle (See section 4.1)

2. Battle phase: Fighting the battle (See section 4.2)

3. Main (2) phase: Prepare yourself for the next turn’s battle (See section 4.3)

After you finish each phase, you have to explicitly request to go to the next phase. At any phase, you
can request to end your turn without waiting for the rest of the phases.

#4.1 Stage 1: Main (1) Phase
The objective of this phase is to setup your field. You setup the field by adding the cards you plan to
use in the next phase to the board and by choosing their modes. The next phase is Battle phase (See
section 4.2).

• You can add cards from your hand deck only.

• A card must be added in a matching type field slot. If all field slots are filled, you cannot add any
cards in this turn. The maximum allowed number of monsters per player in the field is 5 and the
maximum allowed number of spells is 5 (i.e. 10 at a time).

Example 4 You cannot add a monster card to a spell field slot, even if it is empty.

Example 5 You have 5 monsters and 5 spell cards in the field in different modes. You want to
add an extra monster → You are not allowed to do this move because you have no empty slots.

• Once you are done with your changes, you request going to the Battle phase or you end your turn.

#4.1.1 (Monster) Cards Rules

1. Adding a monster to the field:

• Normally, you are allowed to add only 1 monster in this phase to the board regardless its
mode.

• However, you can add more monsters using specific spells cards depending on their descrip-
tion, if available.

2. Modes of the monster: You have to specify a state for the monster when adding it to the field,
either ATTACK or DEFENSE. The mode specifies the power of the monster and the allowed
actions in the next phase.

• Monsters in ATTACK mode: They are added to the field in vertical, flipped up (visible)
position.

• Monsters in DEFENSE mode: They are added to the field in horizontal, flipped down
(hidden) position

3. Level of the monster: Some monsters cannot be added to the field without sacrificing other
monsters. This is indicated by the monster’s level. If the monster’s level is between (The range is
inclusive):

• 1-4: Use directly

• 5-6: Sacrifice 1 monster from the field

• 7-8: Sacrifice 2 monsters from the field

4. Sacrificing a monster: You can sacrifice a monster only if the sacrificed monster is in the field
regardless its mode. Monsters added using spell cards do not require sacrifices.

5. Monster’s strength: Monster mode specifies which power points are activated.
Example 6 If a monster has 2000 points for attack and 1000 points for defense → This monster
is worth 2000 points if it is in a vertical flipped up position on the board (ATTACK mode)

6. You are allowed to update the mode of a monster already in the field following the aforementioned
rules.

7. The mode of any monster card could be updated only once per turn.

8. The monster is used in the Battle phase in the same mode specified here. You can only attack
using a monster in the ATTACK position.

#4.1.2 (Spell) Cards Rules
1. Visibility of the card: It depends on the card mode (See section 2.1.1)

• If the card is set: It should be flipped down (hidden)

• If the card is activated: It should be flipped up (visible)

2. The description of the card specifies the allowed phases for using (activating) it.

3. You can add multiple spell cards as long as you have available slots in the field.

4. Activating a spell card from hand deck: This is simulated by adding the card to the field
slot then using it.

5. After you use (activate) a spell card, you discard it to the graveyard

#4.2 Stage 2: Battle Phase
The objective of this phase is to kill the monsters of your opponent and/or reduce his/her life points.
You can do that by executing attacks on your opponent using your spell cards (if available) and your
ATTACK monsters.

• The maximum allowed number of attacks per turn is equal to the number of monsters
in attacking mode only

– You can attack with each monster only once.

– You attack with one monster at a time then you can attack with the next monster in the
same turn.

– Choosing the number of attacks per turn is optional for the player as long as she does not
exceed the maximum number of allowed attacks (i.e., you do not have to attack with all your
attacking monsters).

• Once you are done with your changes, you request going to the Main (2) phase or you end your
turn.
This phase is divided to two sub-phases:

1. Activate spell cards eligible in Battle phase: There are 2 spell cards that could be activated in
the battle phase. You can find the cards through their description

2. Execute your attack.

#4.2.1 How to Use a Spell Card?
If you do not have any eligible card, you move directly to attacking the monster. Otherwise:

1. You select a spell card from the field slots

2. You select a monster to apply the spell card to, if applicable. The action of the spell card is
performed on the monster.

3. The spell card is discarded in to the graveyard unless specified otherwise.
#4.2.2 How to Attack with a Monster?
1. Specify your attacking monster

2. Specify the target opponent attacked monster. You can attack any monster regardless its mode
(ATTACK or DEFENSE)

3. If the attacked monster is in DEFENSE mode, it must become visible (Flipped up).

4. Execute attack.
#4.2.3 How to Calculate the Score and Result of the Attack?
To simplify the explanation of the score calculation, important names will be given an alias name (Any
symbol like we do in Math). You are free to change the names in the code.
To calculate the score after an attack with a monster, you need 3 values:

1. The attacking power of your monster → Call it: me

2. The mode of the attacked opponent monster → Call it: mode

(a) If the monster is in ATTACK mode → mode= ATTACK

(b) If the monster is in DEFENSE mode → mode= DEFENSE

3. The power of the attacked opponent monster. It depends on its mode → Call it: opp

(a) If the monster is in ATTACK mode → opp= the attacking power of the opponent monster

(b) If the monster is in DEFENSE mode → opp= The defense power of the opponent monster

There are 3 possible scenarios when you attack a monster. According to the scenario, the score and the
consequences are changed.

1. Opponent has no monsters on the board: Deduct me from the life points of the opponent.

2. Opponent monster in DEFENSE mode

(a) me > opp: The opponent monster dies. However, nothing happens to his life points.

(b) me == opp: Nothing happens.

(c) me < opp: The player loses (opp − me) value from her life points. However, nothing happens
to both monsters.

3. Opponent monster in ATTACK mode

(a) me == opp: Both monsters die. However, nothing happens to the life points of both players.

(b) Otherwise:

• Calculate the absolute difference between me and opp

• Choose the weaker monster. A weaker monster is one with a lower attacking power
compared to the other monster.

• The owner of the weak monster loses the difference from his life points. Moreover, the
weaker monster dies.

#4.3Stage 3: Main (2) Phase
The same rules of Main (1) phase apply here. (See section 4.1)

Please find above the milestones' description of the project.
