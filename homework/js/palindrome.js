function checkPalindrome(word)
{
	if (word === word.split("").reverse().join(""))
	{
		return console.log("It is Palindrome");
	}

	return console.log("It is not Palindrome");
}

function recursive(word, firstLetter = 0, lastLetter = word.length - 1)
{
	if (word[firstLetter] === word[lastLetter] && firstLetter !== lastLetter)
	{
		return recursive(word, firstLetter + 1, lastLetter - 1);
	}

	if (word[firstLetter] !== word[lastLetter])
	{
		return console.log("It is not Palindorme");
	}

	return console.log("It is Palindrome");
}

function iterative(word)
{
	for (let i = 0; i < word.length / 2; i++)
	{
		if (word[i] !== word[word.length-1-i])
		{
			return console.log("It is not Palindrome");
		}
	}

	return console.log("It is Palindrome");
}

checkPalindrome("mom");
recursive("racecar");
iterative("level");
