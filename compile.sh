javac -sourcepath ./src/ -d ./build/ ./src/App.java
cd build
jar cvfe ShoppingCart.jar App ./*
echo "Compilation complete. The jar file can be found in ./build/ShoppingCart.jar