ROOT_FOLDER='/opt/java_workspace'
FOLDERS='covibed2'

if [ -d /tmp/build ]
then
rm -rf /tmp/build
fi
mkdir /tmp/build
for folder in $FOLDERS;
do
echo "Compiling $folder  ..."
cd $ROOT_FOLDER/$folder
mvn clean
mvn compile
mvn -Dmaven.test.skip=true package ;
cp $ROOT_FOLDER/$folder/target/*.jar /tmp/build

done
