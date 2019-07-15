

outputString=`python time.py frequencies`
#echo $outputString

IFS=' ' # space is set as delimiter
read -ra ADDR <<< "$outputString"
index=0
startTime=0
for i in "${ADDR[@]}"; do 
	echo index is $index
    IFS='-' # space is set as delimiter
	read -ra ADDR <<< "$i"
	
	endTime=${ADDR[0]}
	ffmpeg -i lucier.mp3 -ss $startTime -to $endTime output$index.mp3
	index=$((index+1))
	startTime=${ADDR[1]}
done

ffmpeg -i lucier.mp3 -ss $startTime output$index.mp3
