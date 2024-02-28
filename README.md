# Introduction
The workshop aims to create a simple shopping cart based on the terminal with the following commands:
- login
- add
- remove
- list
- save
- users
- exit

## Compiling and Running the JAR file

### For Linux
**Ensure** you are in the root directory. 
If you are on Linux, run the compile.sh. Make sure permissions on the script is given, if not, you can run the following: `sudo chmod 750 compile.sh`.
```bash
./compile.sh
```

### For Windows
```git-bash
javac -sourcepath .\src\ -d .\build\ .\src\App.java
cd build
jar cvfe ShoppingCart.jar App .\*
```

## Usage of the application
The application can be run by doing the following: 

```bash
java -jar ShoppingCart.jar [directory of your carts]
```

If no directory is given, it will be defaulted to "cartdb".

