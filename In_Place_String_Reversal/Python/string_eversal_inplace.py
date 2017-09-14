
def reverse(s, start, end):
    length = (len(s[start:end]))/2
    full_length = len(s)
    for i in range(0, length):
        s = s[0:start + i] + s[end-i-1:end-i] + s[start+i+1:end-i-1] + s[start+i:start+i+1] + s[end-i: full_length]
    return s


def reverse_sentence(s):
    s = reverse(s, 0, len(s))
    i = 0
    start = 0
    while i < (len(s)-1):
        if s[i:i+1] == ' ':
            s = reverse(s, start, i)
            i += 1
            start = i
        else:
            i += 1
    s = reverse(s, start, i+1)
    return s


sentence = "This is a sentence I wanna reverse"
print("input: "+sentence)
print("output: "+reverse_sentence(sentence))
