//package Tunezz;




public class Playlist {
	//The name of the playlist.
	String name;
	//This is the head of the linked list. 
	Song first;

	public Playlist(){
		name = "library";
		first = Song.END;
	}

	public Playlist(String name) {
		this.name = name;
		first = Song.END;
	}

	//This method returns the name of the playlist. 
	public String getName() {
		//the variable name is the name of the playlist.
		return name;
	}

	//This returns the first song of the linked list, that is, the linked list. Since the head, "first" is pointing to the 
	//first node, the first song will be returned upon returning the head. 
	public Song head() {
		return first;
	}

	/*This method is supposed to add the given song to the playlist. Thus, this method should create and point to the 
	next node. 
	 */
	public void add(Song song){
		//First, we create a temporary head named temp that points to the first node. 
		Song temp = first;
		/*Then, we use an if-statement to check if the node the head is pointing to has a null reference. In our case, we take
		 * null as "Song.END". If it returns true, then that means this is the only node in the linked list without data, and 
		 * the song will then be written into this node. This is how we add a song to the linked list that is empty. 
		 */
		if (temp == Song.END) { 
			//Writing the song into the node temp is pointing to.
			first = song; 
		}
		/*If the first node has data and is pointing to the second node, then this statement gets executed, where the second
		 * node's data will be written as the song
		 */
		else {
			/*Here, we use a while loop to make sure that it runs until the temporary head reaches the end of the linked
			 * list. 
			 */
			while (temp.next != Song.END) {
				//Here, the temporary head changes to the next node as many times as the loop runs. The statement "temp.next"
				//is used to point to the next node. 
				temp = temp.next;	
			}
			//Thus the first node is not empty, the song gets added to the next node.
			temp.next = song;
		}
	}

	/* This method is called when the user needs to remove the first song of the linked list and this method returns a Song
	 * type object. 
	 */
	public Song removeFirst() {
		/*In this statement we create a temporaray named previous to make sure that the original head, "first" remains
		 * the same.*/
		Song previous = first;
		/*Here, we use an if-statement where the statement will return true until the head is reached to the end. The logic
		 * is that if the first and second nodes exist, then we point the head to the second node from the first node.
		 * Thus, the linked list will completely ignore the first node and skip to the second node.
		 */

		//The statement in the if-statment makes sure that there is more than one node.
		if (first != Song.END) {
			/*If there are more than one nodes, then the first node wil be ignored, since the temporary head will point to
			 * the next node. 
			 */
			first = first.next;
		}
		//The temporary head will be returned over here.
		return previous;	
	}

	/*This method is supposed to be called when the user wants to know the number of songs in the playlist. In other words,
	 * the size of the playlist
	 */
	public int size() {
		/*The logic that we use here is that, we use a loop to traverse through the linked list, till the temporary head
		 * that we assigned will reach the end. To count the number of nudes the loop has traversed through, we will
		 * declare an int variable named numSongs and we increment this in the loop. So, as it will increase by one the
		 * number of times the loop gets executed, i.e., the number of nodes. */

		//Declaring a temporary head names temp.
		Song temp = first;
		//Declaring the integer variable numSongs to count the number of loop executions
		int numSongs = 0;
		//Here, we use a while loop to make sure that temp goes from the first node to the last node, which as Song.END.
		while(temp != Song.END) {
			//We use this statement to move to the next node.
			temp = temp.next;
			//Here, the int value gets incremented as long as the head reaches the end.
			numSongs++;
		}
		//Since numSongs will be the number of nodes crossed, we can return the same variable to display the number of songs.
		return numSongs;
	}

	/*This method should be called when the user wants to know the position of a certain song in the given playlist. If the
	 * playlist does not have the song, "-1" will be returned by the code to display */
	public int getPosition(Song song) {
		/*The logic of this code is that we declare a temporary head and traverse it through the loop while updating its value
		 * every time. The code will stop running when we reach the given song. We also declare an int variable that gets
		 * iterated everytime the condition the loop runs. This int is then returned, which is the position of the song.*/

		//Here, we declare a variable, which is the beginning position.
		int position = 0;
		//We also declare a boolean value to see whether the song has been found or not.
		boolean found = false;
		//We also create a temporary head to make sure that our original head does not change with each method.
		Song temp1 = first;
		/*We use a while loop, with two conditions. The first is that the while loop goes on until found becomes true. In that
		 * case, true becomes false due to the complement, "!" and the while loop fails. The second condition is that the 
		 * loop continues to run until the temporary head reaches the end of the linked list.
		 */
		while (!found && temp1 != Song.END) {
			/*Since the temp head traverses through the entire linked list and its value gets updated each time, when the 
			 * temp head reached */
			if (temp1.equals(song)) {
				//If the temp head reaches the given song data, then found becomes true and while loop is executed.
				found = true;
			}
			//Until temp reahces the given song, this else-statement will get executed.
			else {
				//This statement makes sure that the temp head keeps moving to the next node.
				temp1 = temp1.next;
				//The int variable "position will increment till the song is reached."
				position++;
			}
		}
		//If the song is found, then the incremented position variable will be returned.
		if (found == true) {
			return position;
		}
		/*This statement will be executed if the song is not found. It will return -1, which allows the required statement in
		 * Assignment9.java file to be executed. 
		 * */
		return -1;
	}

	//This method should be called if the user wants to remove a specific song from the playlist. 
	public int remove(Song song) {
		/*Logic of the code: We traverse through the entire linked list and when we find our target song, we 
		 * re write the address of the song before our target song to point towards the song after the target song.
		 * Thus, we completely ignore the target song's node. In other words, we remove it from the playlist.
		 * */

		//Here we make use of the getPosition(<song name>) method we created to make it easier for our code to work.
		int pos = getPosition(song);
		/*If the head is the same as the song that is to be removed, the head is made to point to the second node, skipping
		 * the first node. 
		 */
		if (first == song) {
			//Sine the first song is the same as the song to be removed, we point head to the second node.
			first = first.next;
		}
		//If the song to be removed is not the same as the first song, then this statement will be executed. 
		else {
			/*Here, since we move away from the first node, we start using two temporary nodes. The first one is previous
			 *and the second one is current. Initially, we give them values of the first and the second nodes respectively.
			 */
			Song previous = first;
			Song current = first.next;
			/*Here, we begin our while loop with two conditions. The first one is that the current temporary node will 
			 * traverse through the linked list until it reaches the end. The second condition is the the loop will 
			 * return true until the song to be removed is reached.
			 * */
			while (current != Song.END && !current.equals(song)) {
				/*Here, we keeo travesing the linked list until the target song is reached. When it does reach, then 
				 * we retain the values of the two temporary nodes*/
				previous = current;
				current = current.next;
			}
			//Here we the if-statement to make sure that there is another song/node after our target song
			if (current != Song.END) {
				/*Since we now have the required nodes, we then re route the previous node to the next to the next of the
				 * node, which is current. So, when we reach the required song, we skip it and reroute the previous node
				 * to the next node of the target song*/
				previous.next = current.next;
			}
		}
		//Then return the positon of our target song to tell the user the location of the removed song.
		return pos;
	}

	/*This method is called by the user when they need to display all the songs of the playlist.*/
	public String listSongs() {
		/*Logic of the code: We traverse through the linked list and display the contents every time we visit a node.
		 */

		//Here, we first assign a temporary head named temp.
		Song temp = first;
		/*Then, we use a while loop to traverse through the entire linked list, until the temporary head reaches the end of
		 * the linked list. This is the condition for our while loop.*/ 
		while(temp != Song.END) {
			/*Since we move from one node to another, we display the data of the node, the song every time we visit a new node.
			 *Thus, by this we can display all the songs in the playlist. 
			 */
			System.out.print(temp + "\n");	
			//Here, we move from one node to the next one.
			temp = temp.next;
		}
		/*After displaying all the songs and the temporary head reaches the end, we display the total number of songs with 
		 * the size method and the given format.*/
		return "Total songs: " + size() + ".";
	}
}