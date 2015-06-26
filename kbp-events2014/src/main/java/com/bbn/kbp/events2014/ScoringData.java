package com.bbn.kbp.events2014;

import com.google.common.base.Optional;

import static com.google.common.base.Preconditions.checkNotNull;

public final class ScoringData {

  private final AnswerKey answerKey;
  private final ArgumentOutput argumentOutput;
  private final ResponseLinking systemLinking;
  private final ResponseLinking referenceLinking;

  protected ScoringData(ArgumentOutput argumentOutput, AnswerKey answerKey,
      ResponseLinking systemLinking, ResponseLinking referenceLinking) {
    this.answerKey = answerKey;
    this.argumentOutput = argumentOutput;
    // nullable
    this.systemLinking = systemLinking;
    // nullable
    this.referenceLinking = referenceLinking;
  }

  public Optional<AnswerKey> answerKey() {
    return Optional.fromNullable(answerKey);
  }

  public Optional<ArgumentOutput> systemOutput() {
    return Optional.fromNullable(argumentOutput);
  }

  public Optional<ResponseLinking> systemLinking() {
    return Optional.fromNullable(systemLinking);
  }

  public Optional<ResponseLinking> referenceLinking() {
    return Optional.fromNullable(referenceLinking);
  }

  public static Builder builder() {
    return new Builder();
  }

  public Builder modifiedCopy() {
    Builder ret = new Builder();
    if (answerKey != null) {
      ret. withAnswerKey(answerKey);
    }
    if (argumentOutput != null) {
      ret.withSystemOutput(argumentOutput);
    }
    if (systemLinking != null) {
      ret.withSystemLinking(systemLinking);
    }
    if (referenceLinking != null) {
      ret.withReferenceLinking(referenceLinking);
    }
    return ret;
  }

  public static final class Builder {
    private AnswerKey answerKey = null;
    private ArgumentOutput argumentOutput = null;
    private ResponseLinking systemLinking = null;
    private ResponseLinking referenceLinking = null;

    private Builder() {
    }

    public Builder withAnswerKey(AnswerKey answerKey) {
      this.answerKey = checkNotNull(answerKey);
      return this;
    }

    public Builder withSystemOutput(ArgumentOutput argumentOutput) {
      this.argumentOutput = checkNotNull(argumentOutput);
      return this;
    }

    public Builder withSystemLinking(ResponseLinking systemLinking) {
      this.systemLinking = checkNotNull(systemLinking);
      return this;
    }

    public Builder withReferenceLinking(ResponseLinking referenceLinking) {
      this.referenceLinking = checkNotNull(referenceLinking);
      return this;
    }

    public ScoringData build() {
      return new ScoringData(argumentOutput, answerKey, systemLinking, referenceLinking);
    }
  }
}
