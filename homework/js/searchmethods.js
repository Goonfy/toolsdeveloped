function getRandomCards(numeroCartas)
{
	if (numeroCartas > 13) return "Numero de cartas não disponivel";

	let cardNumbers = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13];
	let cardTypes = ["Copas", "Espadas", "Paus", "Ouros"];

	let randomCards = [];

	for (let i = 0; i < numeroCartas; i++)
	{
		let randomCardNumber = cardNumbers[Math.floor(Math.random() * cardNumbers.length)];
		let randomCardType = cardTypes[Math.floor(Math.random() * cardTypes.length)];

		for (let b = 0; b < randomCards.length; b++)
		{
			while (randomCards[b] === randomCardNumber + " de " + randomCardType)
			{
				console.log("Changed repeated card!!");

				randomCardNumber = cardNumbers[Math.floor(Math.random() * cardNumbers.length)];
				randomCardType = cardTypes[Math.floor(Math.random() * cardTypes.length)];
			}
		}

		randomCards.push(randomCardNumber + " de " + randomCardType);
	}

	console.log("Cartas tiradas aleatoriamente: " + randomCards);

	return randomCards;
}

function convertToLetterCards(cards)
{
	for (let i = 0; i < cards.length; i++)
	{
		switch(parseInt(cards[i]))
		{
			case "1":
				cards[i] = "A";
				break;
			case "11":
                        	cards[i] = "J";
				break;
			case "12":
				cards[i] = "Q";
				break;
			case "13":
				cards[i] = "K";
				break;
			default:
				console.log("Invalid Card");
		}
	}

	return cards;
}

function linearSearch(cardsList)
{
	let randomCard = cardsList[Math.floor(Math.random() * cardsList.length)];
	
	console.log("Card to find: " + randomCard);

	for (let i = 0; i < cardsList.length; i++)
	{
		if (cardsList[i] === randomCard)
		{
			console.log("Card " + randomCard + " it's in the " + (i + 1) + " position");
			
			break;
		}
	}
}

function binarySearch(cardsList)
{
	let sortedCards = sortSelection(cardsList);
	let randomCard = sortedCards[Math.floor(Math.random() * sortedCards.length)];

	let first = 0;
	let last = sortedCards.length - 1;

        console.log("Card to find: " + randomCard);
	
	while (first <= last)
	{	
		let middle = Math.floor((first + last)/2);
		
		if (parseInt(randomCard) === parseInt(sortedCards[middle]))
		{
			return console.log("Card " + randomCard + " it's in the " + (middle + 1) + " position");
		}
		else if (parseInt(randomCard) > parseInt(sortedCards[middle]))
		{
			first = middle + 1;
		}
		else if (parseInt(randomCard) < parseInt(sortedCards[middle]))
		{
			last = middle - 1;
		}
	}
}

function sortSelection(cardsList)
{
	let lastCard;
	let lastCardPos;

	for (let a = 0; a < cardsList.length; a++)
        {
		lastCard = cardsList[a];
		lastCardPos = a;

		for (let b = a; b < cardsList.length; b++)
		{
			if (parseInt(cardsList[b]) < parseInt(lastCard))
			{
				lastCard = cardsList[b];
				lastCardPos = b;
			}
		}
		
		cardsList[lastCardPos] = cardsList[a];
		cardsList[a] = lastCard;
        }

	console.log(cardsList);

	return cardsList;
}

function sortInsertion(cardsList)
{
	for (let a = 0; a < cardsList.length; a++)
	{
		let lastCard = cardsList[a];

		for (let b = a - 1; b >= 0; b--) {
			if (cardsList[b] > lastCard)
			{
				cardsList[b + 1] = cardsList[b];
			}
		}
		
		cardsList[a] = lastCard;
	}

	console.log(cardsList);
}

let randomCards = getRandomCards(7);

linearSearch(randomCards);
binarySearch(randomCards);
sortSelection(randomCards);
sortInsertion(randomCards);
