=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=
CIS 120 Game Project README
PennKey: _______
=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=

===================
=: Core Concepts :=
===================

- List the four core concepts, the features they implement, and why each feature
  is an approprate use of the concept. You may copy and paste from your proposal
  document if you did not change the features you are implementing.

  1. Collections

  2. Inheritance and subtyping

  3. Junit tests

  4. I/O for file parsing


=========================
=: Your Implementation :=
=========================

- Provide an overview of each of the classes in your code, and what their
  function is in the overall game.
  
  Though Circle, Poison and Square are still named after the classes original mushroom of doom game, 
  the content of the all these classes have changed significantly. For my game, there is not need
  for any movement detection as well as collision detection so I deleted code corresponding to 
  those. These three classes are all inherited functions from the GameObject class, and I added 
  another method to the gameobject class that allows me to change the pos_x and pos_y values. This
  makes it easy for me to generate objects randomly across the the game frame.
  
  I have a HighScoreFinder class. This class is responsible for reading and writing scores onto a 
  text file. In the text file, the scores comes first followed by a semicolon followed by the 
  player's name. Using the bufferredreader I can read every line the text file and separate each
  line into two components: the score and the name. I then used a treeMap to map the score to the
  player's name. I did this because I need to collect all the scores, find the highest score and
  then find the player's name associated with the highest score. A treemap structure can help me
  with this process easily. There are methods in HighScoreFinder that allows me to retrieve the 
  highest score, the player name associated with the highest score and add new values to the list.
  To find the highest score, I have a set that contains all the key values of the treemap, and I 
  used a for each loop to find the highest score.
  
  The ReaderAndWriterJUnitTest class is my JUnit test class. I used this class to test the 
  functionality of my bufferedReader and bufferedWriter methods. I need to make sure that when a 
  new score is written in the file and if the new score is the highest score, I need to update the
  Collection in the file so that when I call the getHighestScore and getHighestScorePlaynerName 
  methods it can give my the correct value. Also, I need to make sure that the inputs follow the 
  invariant that it is the score, a semicolon and the name.
  
  Finally, in the GameCourt class I used an arraylist that stores all the current objects on the
  frame and use a for each loop to paint all the GameObj in the arraylist. I used an arraylist 
  because I do not need to override the comparable method if I had used a treeset or a treemap; 
  this saves me some time. Then I used a random number generator and with a method that generates
  a normal mushroom if the it is 0, a one-up mushroom if it is 1 and a poison mushroom if it is 2.
  In addition, I also used the random number generator to randomly generate the x and y coordinates
  of every GameObj. The above code is in tick the tick method. For reset, I cleared all the scores,
  stopped the mouseclick listener and restarted the timer.


- Revisit your proposal document. What components of your plan did you end up
  keeping? What did you have to change? Why?
  
  I mostly followed the proposal but with 2 areas that have significant change.
  
  The first area is that I did not use a 2-D array to represent the game. Originally I plan to 
  create a buffered image with 2-D array representing the pixels. But in actual implementation, I
  realized that simply using an arraylist to represent all the available ojects and repainting them
  would be a more feasible method.
  
  The second area is that I did not have time to implement the method that makes all the shapes 
  disappear after a certain amount time has passed since their appearance. In the beginning, I did 
  not know how to do this so I gave up on this feature. But now after reading some java docs I 
  realized that there is a universal timer than has been counting since the creation of java, and I
  can use that to make my shapes disappear. But I did not have the time to go back to add the 
  feature.


- Were there any significant stumbling blocks while you were implementing your
  game (related to your design, or otherwise)?
  
  When I was implementing the game, I had a very hard time trying to figure out how to make game
  objects disappear over a certain period of time. I also had problems understanding how the timer
  works because this is my first time using the Java Swing library. Later on, I realized that I can
  use the universal timer to make objects disappear over time, but I did not have time in the end
  to implement this feature. However, it does not affect the overall gameplay much.


- Evaluate your design. Is there a good separation of functionality? How well is
  private state encapsulated? What would you refactor, if given the chance?

  I believe it is well-designed. All my classes are separated and all my important variables are 
  declared private. Given the chance, I would actually try to rename or recreate some of the classes
  as I realized my circle class is actually a picture and my square class is also another picture 
  and not a square. I simply don't have the time to change. Also given the chance, I would 
  implement the feature that allows the shapes to disappear over a certain period of time.


========================
=: External Resources :=
========================

- Cite any external resources (libraries, images, tutorials, etc.) that you may
  have used while implementing your game.

I've used 2 additional images online for my game implementation. The links to those pictures are 
listed below: https://www.pinterest.com/pin/303007881154100334/  
http://www.polyvore.com/up_mushroom_super_mario_wiki/thing?id=27389696

