#get times
index=1
for x in *.txt; do
	#echo $x

outputString=`python time.py "$x"`

IFS=' ' # space is set as delimiter
read -ra ADDR <<< "$outputString"

for i in "${ADDR[@]}"; do 
    IFS='-' # dash is set as delimiter
	read -ra ADDR <<< "$i"
	IFS=' ' #resetting IFS value
	startTime=${ADDR[0]}
	endTime=${ADDR[1]}
	startTime=`echo "$startTime-5" | bc`
	endTime=`echo "$endTime+5" | bc`
	name=`basename "$x" .txt.txt`.mp3
	censoredName=censored-`basename "$x" .txt.txt`.mp3
	filteredName=FILTERED-`basename "$x" .txt.txt`.mp3
	echo $startTime
	echo $endTime
	ffmpeg -i "$name" -ss $startTime -to $endTime $index-n.mp3
	ffmpeg -i "$censoredName" -ss $startTime -to $endTime $index-c.mp3
	ffmpeg -i "$filteredName" -ss $startTime -to $endTime $index-f.mp3 
	index=$((index+1))
	#startTime=${ADDR[1]}
done


done

