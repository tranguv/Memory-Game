<h1>Memory Game</h1>
 <p>A matching game implemented using Android Studio and Java.</p>

<h2>Extra Features</h2>
 <p>
  <ul>
 <li>Start menu with 'Start' and 'Rule' button</li>
 <li>Clean user interface</li>
 <li>Go back to homepage option (or exiting the current round)</li>
 <li>Option to choose the game's mode: Easy, Medium, Hard</li>
 <li>Open source and object oriented design</li>
  </ul>
 </p>

<h2>How to Play</h2>
 <ul>
  <li> Regard to this website to open the app on terminal: https://pub.towardsai.net/how-to-run-an-android-application-from-command-line-e139eda62867
</li>    
  <li>On a machine with SDK 32 and Gradle version 7.4</li>  
  <li>Press the start button to choose mode or press rule button to read the manual about the game.</li>
  <li>Find all the 2-pair cards that are matching to win the game, best moves will be counted toward the end of each round.</li>
  <li>If you wish to end the game early, click on the go back (left-arrow) button.</li>
  <li>To play again, exit the game and repeat steps 2 through 7.</li>
 </ul>

<h2>Contributor</h2>
<ul><li>Trang Vu - handles GUI and the back-end of the game</li></ul>

<h2>Game Logic</h2>
<h3>Generate random images to the board</h3>
 <p>Storing a list of images that will be used for the cards. Shuffles the images and choose out the number of images half the size of the numbers of the buttons/boards. For example, Easy Mode with 12 buttons/cards in a board so I'd choose from the shuffled list of cards 6 of them and then created a new array with 12 buttons and assigned randomly 6 cards on it twice</p>

<h3>Pair match checking</h3>
 <p>Cards are an arraylist of buttons with onClick function below each button. Each card will have a variable that check if they're faced up or down; and a variable if they are matched or not. If they are already matched, just keep them face up, otherwise compare their button id, if they're not matched, set the value of isMatched to false and make them face down</p>

<h3>Found all the matches</h3>
<p>When players have found all the matched, a dialogue will appear and congrats them on their achievement and will direct them to the main home page, so they can choose the other modes to continue palying</p>

<h3>Moves and stores moves</h3>
<p>When player flips a card, the move counter is increased by 1 and it will continue to count till the end of the game. The best moves will be kept in the record using SharedPreferences and showing in the next round of the same mode. So, each mode will have different best moves. The best records will still be stored after user closed the app.</p>


<h2>GUI</h2>
<h3>Start Menu</h3>
<p>The XML contains Start and Rules button with onClick function</P>

<h3>Moves and stores moves</h3>
<p>Player's best move will be displayed along with their number of moves</p>
