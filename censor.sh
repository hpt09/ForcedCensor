

outputString=`python time.py`

> edits.txt

IFS=' ' # space is set as delimiter
read -ra ADDR <<< "$outputString"
index=0
startTime=0
for i in "${ADDR[@]}"; do 
	echo index is $index
	echo $i
    IFS='-' # dash is set as delimiter
	read -ra ADDR <<< "$i"
	
	endTime=${ADDR[0]}
	ffmpeg -i $1 -ss $startTime -to $endTime output$index.mp3
	echo file output$index.mp3 >> edits.txt
	index=$((index+1))
	startTime=${ADDR[1]}
done

ffmpeg -i $1 -ss $startTime output$index.mp3
echo file output$index.mp3 >> edits.txt

ffmpeg -f concat -i edits.txt -c copy final.mp3

rm output*mp3
rm edits.txt

