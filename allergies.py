def find_largest_power_of_two(score):
    '''
    Finds the largest power of two that is less than the score.
    '''
    power_of_two = 1
    while power_of_two * 2 <= score:
        power_of_two *= 2
    return power_of_two

class Allergies:
    def __init__(self, score):
        self.score = score
        self.lst = self.get_allergies()

    def get_allergies(self):
        score = self.score
        allergy_dict = {1: 'eggs', 2: 'peanuts', 4: 'shellfish', 8: 'strawberries',
                        16: 'tomatoes', 32: 'chocolate', 64: 'pollen', 128: 'cats'}
        allergens = []
        if score >= 256:
            # ignore unknown allergies
            unknown_score = find_largest_power_of_two(score)
            score -= unknown_score

        # mimic conversion of decimal to binary    
        relevant_allergy_score = find_largest_power_of_two(score)
        while score != 0:
            # allergic only if power of two is less than score
            if score >= relevant_allergy_score:
                score -= relevant_allergy_score
                allergens.append(allergy_dict[relevant_allergy_score])
            relevant_allergy_score /= 2
        return allergens[::-1]

    def is_allergic_to(self, element):
        return element in self.lst



