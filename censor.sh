if [ "$1" == "" ]; then
    echo "No Audio File Provided"
	exit 1
fi

if [ "$2" == "" ]; then
    echo "No Aligned Transcript File Provided"
	exit 1
fi
echo "$1"
echo "$2"
outputString=`python time.py "$2"`

> edits.txt
rm output*mp3 2> /dev/null
rm censored-"$1" 2> /dev/null

IFS=' ' # space is set as delimiter
read -ra ADDR <<< "$outputString"
index=0
startTime=0
for i in "${ADDR[@]}"; do 
    IFS='-' # dash is set as delimiter
	read -ra ADDR <<< "$i"
	IFS=' ' #resetting IFS value
	endTime=${ADDR[0]}
	ffmpeg -i "$1" -ss $startTime -to $endTime output$index.mp3 2> /dev/null
	echo file output$index.mp3 >> edits.txt
	index=$((index+1))
	startTime=${ADDR[1]}
done

ffmpeg -i "$1" -ss $startTime output$index.mp3 2> /dev/null
echo file output$index.mp3 >> edits.txt

ffmpeg -f concat -i edits.txt -c copy trimmed-"$1" 2> /dev/null

rm output*mp3
rm edits.txt
 
