
for x in *.mp3; do
	
	transcript=`basename "$x" .mp3`.txt.txt

	./censor.sh "$x" "$transcript"
	python filter.py "$x" "$transcript"
done
