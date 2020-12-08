echo "Shell Script to Edit all .txt files in the given directory"
if [[ $# -eq 0 ]]
    then
        echo "No Arguments, Please input directory name"
        exit

elif [ -d $1 ] 
    then
        echo "Directory Exists." 
        cd $1
        echo `pwd`
        for file in `ls`
        do
            if [[ $file =~ \.txt ]];
            then
                echo $file
                sed -i '' -e '2d' $file
            fi
        done
else
    echo "Error: Directory does not exists."

fi