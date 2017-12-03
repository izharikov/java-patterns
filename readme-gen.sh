FILES=src/com/patterns/*
i=1
for f in $FILES
do
  echo "$i. [$f](/$f)"
  i=$((i + 1))
  # take action on each file. $f store current file name
done
