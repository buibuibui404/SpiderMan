This is a video game like Super Mario in developing phases

## How to run

Open your terminal and go to the directory which contains build.gradle. Then input 

`gradle run`

## Config guide
DO NOT CHANGE THE FORMAT IN JSON FILE && DO NOT SET COLLISION SITUATION

The JSON file should be put in src/main/java/stickman/

The JSON file name can be changed, but the name in App.java GameEngineImpl() should be changed to the same

For example, if the JSON file name is "example.json", "example.json" should be put in the constructor in App.java


The finish line is a double value. It is the position X. When hero reach the position. The game will end

The life is how many times the hero can start the game after it is damaged. it should be a string which can be parse to positive int directly

stickmanSize should be selected from "tiny" "normal" "large" "giant"

the "x" in stickmanPos should be a positive double smaller than finish line

All of amount for different entities should be a string which can be parse to positive int directly

The num of element in "XXX of Position" should smaller than Integer.parse(the value stored in "The amount of XXX")

It stores (key, value), The key should be a string which can be parse to positive int directly && starts from "1" and increase 1 

For example: "1" "2" "3" ...

The value should be [x, y] both x and y should be positive double value

#### This project follow the Google Java Style Guide

https://google.github.io/styleguide/javaguide.html