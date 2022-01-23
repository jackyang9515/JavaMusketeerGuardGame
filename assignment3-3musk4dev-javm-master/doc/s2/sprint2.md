Sprint Goal
---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	The goal of sprint 2 is to have a fully functioning graphical user interface for players of our ThreeMusketeers game to play on with the previously built separate functions to be implemented altogether and be used by the final product. 
	
All stories for this Sprint (add/delete stories)
---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	User story 1.6/1.8 is to add a board customizer feature into our game, in order for players to build new boards with relative ease. It will make use of CellBuilder that was previously implemented during sprint 1 in user story 1.2. Albeit the board customizer does use CellBuilder in order to construct a new board, but the details of the implementation is based on its integration to the GUI itself. Hence, it was not implemented in sprint 1 due to the nature of the function to be added.

	User story 1.9 is to add a feature to preview a board for users to see the board’s position before actually playing the game, so players can have the option to choose between different save files before actually playing the game. We added this user story at the end of sprint 1 to be completed in sprint 2.

	User story 2.1 is to add sound effects upon the movement of pieces: whenever guard pieces are killed by musketeer pieces, or upon winning or losing a game. This allows for a more immersive experience with auditory stimuli in the game.

	User story 2.2 is a turn counter visualizer that will utilize the undo and redo functionality from user story 1.1; the iterator design pattern from user story 1.1 serves as a model for the view that is the turn counter under the playing board. The turn counter will highlight the board’s current turn upon undoing or redoing previously performed moves, and is an observer that observes the MovesHistory iterable, in order to update the current moves list.

	User story 2.3 is to add a fully fleshed out GUI of the game. This will include all the scenes (acting as the view of MVC) of the game, including the main menu, board selection menu, playing board, settings, theme selection, and credits. These scenes are updated by the panels (controllers) that fetch updates from the ThreeMusketeers class (model).

	User story 2.4 is to implement the save option that exists in the base ThreeMusketeers game and implement it as a GUI that allows for a default of the current timestamp or possible renaming of the board’s save file. This will update the list of boards available to be played on the board selection screen. 

Assessment of team capacity
---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	Aedas - 20 hours over the first 2-3 days to implement the GUI 
	Marko - 10 hours to go over the code and implement turn visualizer; also to test the game for any possible bugs.
	Vicky - 15 hours to implement the board customizer(boardbuilder panel and scene and generateboard). 
	Jack - 7-8 hours to implement the save function, and game over situation

Participants in the sprint process
---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	  Aedas will implement user story 2.3 - most of the GUI related items.   
	  Marko will implement user story 2.2 - turn counter visualizer.
	  Vicky will follow through with user stories 1.6/1.8 and 2.1. 
	  Jack will implement the user story 2.4 - save button GUI.

Breakdown of tasks
---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------	
	The implementation of the GUI will be led by Aedas, who will be constructing the MVC (ThreeMusketeers, Scenes, Panels for model, view, controller respectively). Afterwards, Marko, Vicky and Jack will implement the separate functions and details into the game, whilst Aedas works on adding the customizability of themes into the settings. For each component, one of the other three that are free at hand will serve as the inspector and assist in debugging the implemented segments. 
